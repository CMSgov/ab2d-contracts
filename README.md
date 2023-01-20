# Ab2d-Contracts

This service gets data from hpms and shares contract information with other services.

### Running Locally with Intelij

1. Run Postgress/SQS using Docker and localstack

   ```ShellSession
   $ docker-compose up db localstack
   ```

Contract Service Setup
2. Select Run/Debug Configuration > Edit Configurations > add configuration (+) > Spring Boot
3. In Main Class select gov.cms.ab2d.contracts.SpringBootApp
4. Go to 1Password and search for 'Event Service Local Env Variables' or 'AB2D Local Env Variables'. Use the configs in the note for the Environment Variables field
5. Run the configuration

### Rest Examples
1. Go to path to access swagger Locally: http://localhost:8070/swagger-ui/index.html





