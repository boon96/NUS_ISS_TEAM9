# Stage 1: Build the React application
FROM node:14 AS builder

# Set the working directory in the container
WORKDIR /app

# Copy package.json and package-lock.json files to the container
COPY package*.json ./

# Install dependencies
RUN npm install

# Copy the rest of the application source code
COPY . .

# Build the React app
RUN npm run builder

# Stage 2: Serve the React application using Nginx
FROM nginx:alpine

# Copy the build output from Stage 1 to the Nginx server's public directory
COPY --from=builder /app/build /usr/share/nginx/html

# Expose port 80 to the Docker host, so it can be accessed from outside the container
EXPOSE 80

# Command to start Nginx and keep it running in the foreground
CMD ["nginx", "-g", "daemon off;"]
