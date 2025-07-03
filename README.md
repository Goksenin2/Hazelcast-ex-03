### hazelcast-ex-03
A simple Java demo that connects to a Hazelcast cluster, puts 10 000 Person objects into a distributed map, then retrieves samples to verify.

Repository Structure
hazelcast-ex-03
├── README.md
├── pom.xml
├── src
│   └── main
│       └── java
│           └── demo
│               ├── Person.java
│               └── HazelcastMapExample.java
└── screenshots
    ├── docker-ps
    └── demo-output
.gitignore filters out compiled files and IDE metadata.

pom.xml declares the Hazelcast dependency and build plugins.

src/main/java/demo holds Person.java and the demo client.

screenshots contains proof images of container mapping and demo output.

.gitignore
/target
*.log
*.class

# IDE
*.iml
.idea
.vscode

# macOS
.DS_Store
Prerequisites
Java 11 or later installed on your machine.

Maven installed, or use the Maven wrapper.

Docker installed and running.

Build
Run in the project root:

bash
mvn clean compile
This downloads dependencies and compiles the code.

Run
1. Start Hazelcast Server
bash
docker run -d \
  --name hazelcast-server \
  -p 5701:5701 \
  hazelcast/hazelcast:latest
2. Verify with Docker
bash
docker ps
Look for hazelcast-server with 0.0.0.0:5701->5701/tcp under PORTS.

3. Execute the Demo Client
bash
mvn exec:java \
  -Dexec.mainClass="demo.HazelcastMapExample"
Expected output:

Inserted 10,000 Person objects.
Retrieved at 0: Person{name='Person-0'}
Retrieved at 2500: Person{name='Person-2500'}
Retrieved at 5000: Person{name='Person-5000'}
Retrieved at 7500: Person{name='Person-7500'}
Retrieved at 0: Person{name='Person-0'}# Hazelcast-ex-03
