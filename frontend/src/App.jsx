import { useState } from 'react'

const API_BASE = 'http://localhost:8080/api/weather'

export default function App() {
  const [city, setCity] = useState('')
  const [weather, setWeather] = useState(null)
  const [error, setError] = useState('')
  const [loading, setLoading] = useState(false)

  const loadByCity = async () => {
    if (!city.trim()) return
    await fetchWeather(`${API_BASE}/city?city=${encodeURIComponent(city.trim())}`)
  }

  const loadByLocation = async () => {
    if (!navigator.geolocation) {
      setError('Geolocation is not supported by this browser.')
      return
    }

    navigator.geolocation.getCurrentPosition(
      async ({ coords }) => {
        const { latitude, longitude } = coords
        await fetchWeather(`${API_BASE}/coordinates?lat=${latitude}&lon=${longitude}`)
      },
      () => setError('Unable to get your location. Please allow location access.')
    )
  }

  const fetchWeather = async (url) => {
    setLoading(true)
    setError('')
    setWeather(null)

    try {
      const res = await fetch(url)
      if (!res.ok) {
        const body = await res.json().catch(() => ({}))
        throw new Error(body.message || 'Failed to fetch weather')
      }
      setWeather(await res.json())
    } catch (err) {
      setError(err.message)
    } finally {
      setLoading(false)
    }
  }

  return (
    <main className="container">
      <h1>Weather App</h1>
      <div className="controls">
        <input
          value={city}
          onChange={(e) => setCity(e.target.value)}
          placeholder="Enter city"
        />
        <button onClick={loadByCity}>Get by City</button>
        <button onClick={loadByLocation}>Use Current Location</button>
      </div>

      {loading && <p>Loading...</p>}
      {error && <p className="error">{error}</p>}

      {weather && (
        <section className="card">
          <h2>{weather.locationName}</h2>
          <p>Temperature: {weather.temperatureC} °C</p>
          <p>Wind: {weather.windSpeedKph} km/h</p>
          <p>Weather Code: {weather.weatherCode}</p>
          <p>Time: {weather.timestamp}</p>
          <small>
            Coordinates: {weather.latitude}, {weather.longitude}
          </small>
        </section>
      )}
    </main>
  )
}
