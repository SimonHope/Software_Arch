const express = require('express');
const cache = require('memory-cache');
const axios = require('axios')
const PORT = process.env.PORT || 3001;

var app = express();
app.use(express.json());

// Listen port
app.listen(PORT,() => console.log('Express server is running on port : ' + PORT));

// Get /{area} /{location}
app.get('/api/timezone/:area/:location', (req, res) =>{
    var arealoc = req.params.area + "/" + req.params.location;

    if(cache.get(arealoc)){
        console.log(cache.get(arealoc));
        res.send(cache.get(arealoc));
    }
    else{
        axios.get('http://worldtimeapi.org/api/timezone/'+arealoc).then(response =>{
            cache.put(arealoc, response.data.datetime,120*1000);
            console.log(response.data.datetime);
            res.send(response.datetime);
        })
    }
});

// DELETE /{area}/{location}
app.delete('/api/timezone/:area/:location', async (req, res) => {
    var arealoc = req.params.area + '/' + req.params.location;
    
    //clear timezone cache
    cache.clear(arealoc);
  
    axios.get('http://worldtimeapi.org/api/timezone/'+arealoc).then(response => {
      cache.put(arealoc, response.data.datetime, 120*1000); //expire in 120sec
      console.log(response.data.datetime);
      res.send(response.data.datetime);
    })
  });