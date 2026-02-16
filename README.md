# Weather App Sprint-1 Scaffold

Minimal full-stack weather app using:
- **Backend:** Spring Boot (Java 17)
- **Frontend:** React + Vite
- **Weather Source:** Open-Meteo APIs (no API key required)

## Project Structure

- `backend/` Spring Boot REST API
- `frontend/` React UI

---

## Backend (Spring Boot)

### Endpoints

- `GET /api/weather/city?city=London`
- `GET /api/weather/coordinates?lat=40.7128&lon=-74.0060`

Response shape:

```json
{
  "locationName": "London",
  "latitude": 51.5,
  "longitude": -0.12,
  "temperatureC": 11.4,
  "windSpeedKph": 7.2,
  "weatherCode": 3,
  "timestamp": "2026-02-16T18:15"
}
```

### Run backend

```bash
cd backend
mvn spring-boot:run
```

Backend runs on `http://localhost:8080`.

---

## Frontend (React)

UI includes:
- City input + **Get by City** button
- **Use Current Location** button (browser geolocation)
- Weather result card

### Run frontend

```bash
cd frontend
npm install
npm run dev
```

Frontend runs on `http://localhost:5173` and calls backend on port `8080`.

---

## Notes

- CORS is enabled in backend for `http://localhost:5173`.
- Open-Meteo geocoding is used for city lookup and forecast API for current weather.
