#!/bin/bash

# === CONFIGURA TUS VARIABLES ===
AWS_REGION="us-east-1"
AWS_ACCOUNT_ID="368406342625"
REPO_NAME="tienda-virtual"
IMAGE_TAG="latest"

# === CREDENCIALES DE BASE DE DATOS ===
SPRING_DATASOURCE_URL="jdbc:mysql://tiendavirtual.cki7zhumcf5q.us-east-1.rds.amazonaws.com:3306/perfumesdb"
SPRING_DATASOURCE_USERNAME="admin"
SPRING_DATASOURCE_PASSWORD="inf13lp20251"

# === AUTENTICACIÓN ECR ===
echo "Autenticando en ECR..."
aws ecr get-login-password --region $AWS_REGION | \
  docker login --username AWS --password-stdin ${AWS_ACCOUNT_ID}.dkr.ecr.${AWS_REGION}.amazonaws.com

if [ $? -ne 0 ]; then
  echo "Falló la autenticación en ECR."
  exit 1
fi

# === DESCARGAR IMAGEN ===
echo "Descargando la imagen desde ECR..."
docker pull ${AWS_ACCOUNT_ID}.dkr.ecr.${AWS_REGION}.amazonaws.com/${REPO_NAME}:${IMAGE_TAG}

# === DETENER Y ELIMINAR CONTENEDOR ANTERIOR ===
if [ "$(docker ps -q -f name=tienda-virtual)" ]; then
  docker stop tienda-virtual
fi

if [ "$(docker ps -aq -f name=tienda-virtual)" ]; then
  docker rm tienda-virtual
fi

# === INICIAR NUEVO CONTENEDOR ===
echo "Iniciando nuevo contenedor..."
docker run -d \
  --name tienda-virtual \
  -e SPRING_DATASOURCE_URL=$SPRING_DATASOURCE_URL \
  -e SPRING_DATASOURCE_USERNAME=$SPRING_DATASOURCE_USERNAME \
  -e SPRING_DATASOURCE_PASSWORD=$SPRING_DATASOURCE_PASSWORD \
  -p 8080:8080 \
  ${AWS_ACCOUNT_ID}.dkr.ecr.${AWS_REGION}.amazonaws.com/${REPO_NAME}:${IMAGE_TAG}

echo "✅ Contenedor desplegado correctamente en http://<IP_PUBLICA_DE_EC2>:8080"
