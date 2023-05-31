# Fitness-Tracker-API

The Fitness Tracker API allows users to track their workouts, 
record fitness progress, and manage their fitness goals. 
This API provides endpoints for creating, reading, updating, and deleting workout records, 
as well as tracking progress and nutrition information.

# API Endpoints

1. Create Workout
- URL: POST /fitness/workouts
- Description: Create a new workout record.
- Request Body:
 {
  "workoutType": "string",
  "duration": 0.0,
  "intensity": "string",
  "title": "string",
  "date": "YYYY-MM-DD",
  "weight": 0.0,
  "height": 0.0,
  "food": "string",
  "calories": 0
}
- Response: HTTP status code 201 (Created) if successful.

2. Get Workout History
- URL: GET /fitness/workouts
- Description: Get the workout history with optional filters.
- Query Parameters:
- workoutType (optional): Filter workouts by workout type.
- date (optional): Filter workouts by date (YYYY-MM-DD format).
- Response: An array of workout records.

3. Update Workout
- URL: PUT /fitness/workouts/{id}
- Description: Update an existing workout record.
- Path Parameter: id - ID of the workout record to update.
- Request Body: Same as the Create Workout request body.
- Response: HTTP status code 204 (No Content) if successful.

4. Delete Workout
- URL: DELETE /fitness/workouts/{id}
- Description: Delete an existing workout record.
- Path Parameter: id - ID of the workout record to delete.
- Response: HTTP status code 204 (No Content) if successful.

5. Track Progress
- URL: POST /fitness/progress
- Description: Track fitness progress, including weight, body measurements, and nutrition information.
- Request Body:
 {
  "weight": 0.0,
  "height": 0.0,
  "food": "string",
  "calories": 0
 }
- Response: HTTP status code 201 (Created) if successful.

6. Get Progress History
- URL: GET /fitness/progress
- Description: Get the progress history.
- Response: An array of progress records.

7. Technologies Used
- Java
- Spring Boot
- Spring Data JPA
- PostgreSQL
- RESTful API

#Conclusion
This README file provides an overview of the Fitness Tracker API, 
including the available endpoints, request/response details, technologies used, 
and instructions for running the application locally. For more detailed documentation, 
consider generating API documentation using tools like Swagger or documenting the API endpoints in more depth.




