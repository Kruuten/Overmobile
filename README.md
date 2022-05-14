# Overmobile test task
Spring boot App on jdk18, jetty11, mongodb5, gradle7

### Instrucion to install: ###
#### 1. Clone project. From command line: ####
> $ git clone --recursive https://github.com/Kruuten/Overmobile

#### 2. Free ports for launching: ####
> DB:27017 
> backend:8080

#### 3. Enter project directory: ####
>$ cd Overmobile

#### 4. Deploy project with Docker (should be installed): ####
> $ docker-compose up -d

#### 5. Check app: ####
> $ Webview only CRUD methods: http://localhost:8080/swagger
> or you can use Postman http://localhost:8080/add =)
