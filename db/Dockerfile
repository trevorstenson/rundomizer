FROM postgres
ENV POSTGRES_DB users
WORKDIR /docker-entrypoint-initdb.d
ADD rundomizer_db_backup.sql .
EXPOSE 5432