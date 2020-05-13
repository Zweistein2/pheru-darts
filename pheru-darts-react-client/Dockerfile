#### Stage 1: Build the react application
FROM node:13.12.0-alpine as build

# set working directory
WORKDIR /app

# add `/app/node_modules/.bin` to $PATH
ENV PATH /app/node_modules/.bin:$PATH

# install app dependencies
COPY package.json ./
COPY package-lock.json ./
RUN npm ci --silent
RUN npm install react-scripts@3.4.1 -g --silent

# add app
COPY . ./

RUN npm run build

#### Stage 2: Serve the React application from Nginx
FROM nginx:stable-alpine

# Copy the react build from Stage 1
COPY --from=build /app/build /usr/share/nginx/html

RUN chmod -R 755 /usr/share/nginx/html

# Expose port 80 to the Docker host, so we can access it
# from the outside.
EXPOSE 80

CMD ["nginx", "-g", "daemon off;"]