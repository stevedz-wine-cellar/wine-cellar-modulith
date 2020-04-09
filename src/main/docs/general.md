# Wine cellar

## Description

### Functional

The purpose of the wine-cellar application is to be able to manage your collection of Wines. 
In addition, you can create tasting notes of wines you may have tasted which are part or have been part of your collection.

### Technical

The application consists of 2 parts. 
A backend application running on Google App Engine and a Frontend Single Page Application deployed to firebase.

#### Backend

The backend application is a DDD designed modulith. It's one deployable unit which runs on the GAE platform.
The modulith architecture has been chosen deliberately.
The aim is to be able to split up the application into multiple microservices when our boundaries have more or less stabilised or when traffic and load necessitate the split. 

#### Frontend

The frontend application will be an Ionic/Angular based SPA/PWA. We'll be hosting it on Google Firebase.
Here also, we'll be applying DDD techniques to have a clean seperation between business boundaries.

## How to deploy

### Backend

Deploying the backend application to GAE can be done in 2 ways. Using the GAE maven plugin OR by using the gcloud CLI.

#### GAE maven plugin

GAE PLUGIN

#### GCloud CLI

GCLOUD CLI

