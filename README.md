Mosque Finder Application

Mosque Finder is a simple yet powerful tool designed to help users locate the nearest mosque based on their current location. Developed by Yusuf Ghani and Ali Mohammed, this application currently supports locations within the Chicagoland area with data stored in a lightweight SQLite database.

🔍 Features

Location Input: Accepts user’s latitude/longitude or address string.

Nearest Mosque Output: Calculates and returns the closest mosque in Chicagoland.

Flexible Querying: Supports both coordinate-based and geocoded address lookups.

Batch Lookup: Ability to find mosques for multiple locations in a single call.

Error Handling: Graceful fallback when no mosques are found or invalid input is provided.

Logging: Records lookup requests and results for audit and analytics.

🛠️ Tech Stack

Back-end: Python (Flask / FastAPI) or Node.js (Express)

Database: SQLite for local storage and rapid prototyping

Geocoding: Optional integration with Google Maps Geocoding API or OpenStreetMap Nominatim

Distance Calculation: Haversine formula for accurate earth-distance computation

Testing: pytest / Mocha with coverage reports

Containerization (future): Docker for consistent deployment

⚙️ Installation & Setup

Clone the repository

git clone https://github.com/ChampionYusuf1/mosque-finder.git
cd mosque-finder

Install Dependencies

Python:

python3 -m venv venv
source venv/bin/activate
pip install -r requirements.txt

Node.js:

npm install

Initialize Database

sqlite3 data/mosques.db < scripts/init_db.sql
# Optionally seed initial entries:
sqlite3 data/mosques.db < scripts/seed_data.sql

Configure Environment

Copy .env.example to .env and update any keys (e.g., GEOCODING_API_KEY).

Run the Application

Python:

uvicorn app.main:app --reload

Node.js:

npm start

🚀 Usage

API Endpoints

GET /api/nearest?lat={latitude}&lng={longitude}

GET /api/nearest?address={URL-encoded address}

Response Example:

{
  "mosque": {
    "id": 12,
    "name": "Al-Falah Mosque",
    "address": "1234 Mosque St, Chicago, IL",
    "latitude": 41.880013,
    "longitude": -87.621551,
    "distance_miles": 0.8
  }
}

CLI Usage

python find_mosque.py --lat 41.88 --lng -87.62
# OR
python find_mosque.py --address "1515 S Michigan Ave, Chicago, IL"

📂 Database Schema

CREATE TABLE mosques (
  id INTEGER PRIMARY KEY,
  name TEXT NOT NULL,
  address TEXT NOT NULL,
  latitude REAL NOT NULL,
  longitude REAL NOT NULL,
  created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP
);

🧪 Testing

Python

pytest --cov=app tests/

Node.js

npm test

🤝 Contributing

We welcome contributions! Please follow these steps:

Fork the repository.

Create a feature branch: git checkout -b feature/YourFeature.

Commit your changes: git commit -m "Add awesome feature".

Push to your branch: git push origin feature/YourFeature.

Open a Pull Request and describe your changes.

Please adhere to the existing code style and include tests for new functionality.

🗺️ Roadmap

SQLite Integration: Complete migration from hard-coded values to database reads/writes.

Coverage Expansion: Add support for cities beyond Chicagoland.

Enhanced UI/UX: Implement a web/mobile frontend with interactive map view and direction links.

Mobile/Platform Support: Develop Android/iOS app or cross-platform solution (e.g., React Native).

Dockerization: Provide Docker Compose setup for easy deployment.

Analytics Dashboard: Visualize lookup statistics and usage trends.

📄 License

This project is licensed under the MIT License. See LICENSE for details.

✉️ Contact

Yusuf Ghani: github.com/ChampionYusuf1

Ali Mohammed: github.com/ali-mohammed0419

Built with ❤️ and SQLite in Chicago
