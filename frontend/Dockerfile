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

# Expose the port on which your frontend application runs
EXPOSE 3000

# Command to start the frontend application
CMD ["npm", "start"]