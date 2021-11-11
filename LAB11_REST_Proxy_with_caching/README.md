# Rest Proxy With Caching

- Get caching 120 second
- GET Method for get current world time with caching
- DELETE Method for current world time without caching

## Project setup

```
npm install
```

## Compile

```
node index.js
```

## Example

```
http://localhost:3001/api/timezone/:area/:location
```

## Get method

```
# curl "http://localhost:3001/api/timezone/Europe/Zurich"
2021-11-11T09:38:17.061340+01:00
```

## Delete method

```
# curl --request DELETE http://localhost:3001/api/timezone/Asia/Bangkok
2021-11-10T18:22:10.891808+07:00
```

## Reference

- OPEN API [WorldTimeAPI](http://worldtimeapi.org/)
- Caching with [memory-cache](https://www.npmjs.com/package/memory-cache)
- Request to WorldTimeAPI with [axios](https://www.npmjs.com/package/axios)
