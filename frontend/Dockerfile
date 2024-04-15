# Use an appropriate base image for Node.js
FROM node:14

# Set the working directory inside the container
WORKDIR /app

# Copy package.json and package-lock.json files
COPY package*.json ./

# Install dependencies
RUN npm install

# Copy the rest of the application source code
COPY . .

# Build your app
RUN npm run build
 
# Serve the React application using Nginx
FROM nginx:alpine
 
# Copy the build output to replace the default nginx contents.
COPY --from=build /app/build /usr/share/nginx/html
 
# Copy the custom nginx configuration file
COPY default.conf /etc/nginx/conf.d/default.conf
 
# Expose port 3000 to the Docker host, so we can access it
# from the outside.
EXPOSE 3000
 
# Start Nginx and keep it running in the foreground
CMD ["nginx", "-g", "daemon off;"]
