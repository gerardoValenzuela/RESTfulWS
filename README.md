# RESTfulWS

-Repositorio git para el curso de Programación Avanzada en Java de la Universidad TecMilenio

## Instalación

### 1.-crear el war de la aplicacion

   se posiciona en el directorio de la aplicación en el que reside el archivo POM.xml y se ejecuta

   Esto se hace utilizando las instrucciones
   
   mvn clean install
   
   ó
   
   mvn clean package
   
   esto creara el archivo CS13304.war
   
### 2.-instalar el archivo war en el servidor Tomcat

  esto se hace  copiando el archivo war en el directorio webapps del directorio de instalación del servidor web, en mi caso es:
  
  C:\Program Files\Apache Software Foundation\Tomcat 9.0\webapps
  
  automaticamente al iniciar el servidor Tomcat instala la aplicación 

### 3.-ejecutar Tomcat

  Esto se realiza ejecutando el archivo por lotes startup.bat en windows o startup.sh en linux

## Uso

se puede utilizar con httpie consumiendo los siguientes servicios

C:\evidencia\RESTfulWS>http get http://localhost:8080/utm/api/v1/ Accept:application/json

Lo cual generara  los siguientes links

HTTP/1.1 200

Content-Type: application/json

Date: Thu, 09 May 2019 20:45:25 GMT

Transfer-Encoding: chunked


{

    "_links": [
    
        {
        
            "href": "http://localhost:8080/utm/api/v1/",
            
            "rel": "api"
            
        },
        
        {
        
            "href": "http://localhost:8080/utm/api/v1/file/",
            
            "rel": "file"
            
        },
        
        {
        
            "href": "http://localhost:8080/utm/api/v1/directory/",
            
            "rel": "directory"
            
        },
        
        {
        
            "href": "http://localhost:8080/utm/api/v1/notify/",
            
            "rel": "notify"
            
        },
        
        {
        
            "href": "http://localhost:8080/utm/api/v1/user/",
            
            "rel": "user"
            
        },
        
        {
        
            "href": "http://localhost:8080/utm/api/v1/index/",
            
            "rel": "index"
            
        }
        
    ],
    
    "version": "1"
    
}


Si uno sigue cada uno de los links que va apareciendo, podra recorrer todas los servicios disponibles de la aplicacion

## Créditos

Programador Gerardo Valenzuela

## Licencia
