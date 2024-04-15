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

# Copy the build output from the build stage to serve the application
COPY --from=build /app/build /usr/share/nginx/html
RUN rm /etc/nginx/conf.d/default.conf
COPY ./nginx/nginx.conf /etc/nginx/conf.d

# Expose port 3000
EXPOSE 3000

# Command to start Nginx and serve the application
CMD ["nginx", "-g", "daemon off;"]
