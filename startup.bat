set DATABASE_URL=postgres://postgres:postgres@localhost:5432/mktmsg
set APPLICATION_WEBSITE=http://localhost:4200
set AUTHENTICATOR_SERVER=https://gz31jsakaj.execute-api.sa-east-1.amazonaws.com/v1
java -jar ./target/security-mktmsg-1.0.0-SNAPSHOT.jar
