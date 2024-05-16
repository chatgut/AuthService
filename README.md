# URL Shortener Service
This is a URL shortener service that takes a long URL and then returns a short URL.

The short URL can then be used to redirect back to the long URL.

# Start up Docker
- Use 'docker-compose up'

# How to use the service 
POST Request: http://localhost:8080/api/url/shorten

- Go to 'Body' (choose 'raw' and 'JSON')

Add: { "url": "https://www.facebook.com/example/very/long/url" }

Example response: http://localhost:8080/abc123

- To get redirected back to the original url:

GET Request: http://localhost:8080/abc123

Response: https://www.facebook.com/example/very/long/url