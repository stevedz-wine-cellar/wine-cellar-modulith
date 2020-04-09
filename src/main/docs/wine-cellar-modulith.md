# Wine Cellar Modulith

## Run locally

In order to run the GAE application locally you need access to a local instance of Google Cloud Datastore.
You can run such a local instance using an emulator.

More details on running the emulator and having the correct environment variables set, can be found here: https://cloud.google.com/datastore/docs/tools/datastore-emulator

Spring Boot also conveniently provides properties which allow us to use spring boot configuration to start up an emulator. 
This comes in handy when running your application locally or when running integration tests.
See: https://cloud.spring.io/spring-cloud-static/spring-cloud-gcp/1.2.0.RC2/reference/html/#cloud-datastore-settings

Now we want to use that emulator when running the application locally.
However, google cloud will look for credentials to access that datastore. 
When running on GAE, the application automatically detects those credentials. 
When running locally however we need to explicitly set these credentails so our application is able to detect these.

run `gcloud auth application-default --help`
This command displays information on how to set credentials for local development.

run `gcloud auth application-default login` to have local credentials setup using your google account.

After running these steps, we're able to locally run an application that depends on Google Cloud Datastore!
