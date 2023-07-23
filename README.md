1) We have service that accept request GET http://localhost:80/api and return jpeg picture as response
2) we have OpenResty (nginx) web server as reverse and cache proxy
3) We first run service that run openresty with docker-compose
4) When we request picture third time - nginx returns us cached picture from nginxcache folder (mounted as volume)
5) When we request same endpoint but with request type PURGE - we delete cached picture in nginx
6) To delete picture we use small Lua script (chatGPT helped me to write it). Please check nginx/nginx.config to view it
