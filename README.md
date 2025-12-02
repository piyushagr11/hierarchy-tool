# hierarchy-tool

Thin host app that surfaces SnapAdmin for SupplyChain entities.

## Description

This project is a standalone host application that uses [SnapAdmin](https://snapadmin.dev/) to provide a web-based admin interface for managing the SupplyChain entity hierarchy. It defines a three-level entity hierarchy:

- **VehicleType** (root level) - e.g., Car, Truck, Motorcycle
- **Brand** (child of VehicleType) - e.g., Toyota, Honda
  - **VehicleModel** (child of Brand) - e.g., Camry, Civic
  - **AutoParts** (child of Brand) - e.g., Engine Parts, Brake Systems

## Prerequisites

- Java 17
- Maven
- PostgreSQL database

## Local Dependencies

This project uses a **locally forked version** of [SnapAdmin](https://snapadmin.dev/) located at `c:\Projects\SupplyChain\snap-admin`. 

- **Version**: 0.2.2
- **GroupId**: `tech.ailef`
- **ArtifactId**: `snap-admin`

If you need to debug or modify SnapAdmin behavior, you can make changes to the local fork and rebuild:

```bash
cd c:\Projects\SupplyChain\snap-admin
mvn clean install
```

This will install the updated version to your local Maven repository, and hierarchy-tool will pick up the changes on next build.

## Configuration

The application is configured to run on port **9090** and uses **PostgreSQL** as the database.

### Key Properties

- **Server Port**: `9090`
- **Database**: PostgreSQL
- **SnapAdmin Base URL**: `admin`
- **SnapAdmin Models Package**: `com.supplychain.hierarchytool.model`

### Database Configuration

The application uses environment variables for PostgreSQL connection settings. You can configure these by setting the following environment variables:

| Variable | Default Value | Description |
|----------|---------------|-------------|
| `DB_HOST` | `localhost` | PostgreSQL server host |
| `DB_PORT` | `5432` | PostgreSQL server port |
| `DB_NAME` | `catalog` | Database name |
| `DB_USERNAME` | `postgres` | Database username |
| `DB_PASSWORD` | _(empty)_ | Database password |

**Example (Windows PowerShell):**
```powershell
$env:DB_HOST="localhost"
$env:DB_PORT="5432"
$env:DB_NAME="catalog"
$env:DB_USERNAME="postgres"
$env:DB_PASSWORD="your_password"
```

**Example (Linux/Mac):**
```bash
export DB_HOST=localhost
export DB_PORT=5432
export DB_NAME=catalog
export DB_USERNAME=postgres
export DB_PASSWORD=your_password
```

## How to Run

You can run the application using Maven:

```bash
mvn spring-boot:run
```

## How to Access

Once the application is running, you can access the SnapAdmin interface at:

[http://localhost:9090/admin](http://localhost:9090/admin)
