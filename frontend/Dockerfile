# Stage 1: Build the React app
FROM node:16-alpine as build
WORKDIR /app

# Copy package.json and package-lock.json to the working directory
COPY package*.json ./

# Install dependencies
RUN npm install

# Copy the rest of the application code
COPY . .

# Run the build script
RUN npm run build

# Stage 2: Serve the React application using Nginx
FROM nginx:alpine

# Remove the default Nginx configuration
RUN rm /etc/nginx/conf.d/default.conf

# Copy your custom nginx.conf to the Nginx configuration directory
COPY nginx.conf /etc/nginx/conf.d

# Copy the build output from the build stage to serve the application
COPY --from=build /app/build /usr/share/nginx/html

# Expose port 3000
EXPOSE 3000

# Command to start Nginx and serve the application
CMD ["nginx", "-g", "daemon off;"]
