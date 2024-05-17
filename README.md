# URL Shortener Service
This is a URL shortener service that takes a long URL and then returns a short URL.

The short URL can then be used to redirect to the website.

<h2>How to get started</h2>

- Clone my repository

<h2>Write this in terminal</h2>

- docker build -t url_shortener .
- docker-compose up

<h2> How to use the service </h2>
POST Request: http://localhost:8080/shorten

- Go to 'Body' (choose 'raw' and 'JSON')

Add:
``
{
"url": "https://www.facebook.com/very/long/url/example"
}
``

<h4>Example response:</h4>
````
{
"shortUrl": "http://localhost:8080/abc1234"
}
````

- To get redirected back to the original url:

GET Request: http://localhost:8080/abc1234