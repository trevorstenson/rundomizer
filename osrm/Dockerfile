FROM osrm/osrm-backend
RUN  apt-get update \
  && apt-get install -y wget \
  && rm -rf /var/lib/apt/lists/*
RUN wget https://download.geofabrik.de/north-america/us/massachusetts-latest.osm.pbf
RUN osrm-extract -p /opt/car.lua massachusetts-latest.osm.pbf
RUN osrm-partition massachusetts-latest.osm.pbf
RUN osrm-customize massachusetts-latest.osm.pbf