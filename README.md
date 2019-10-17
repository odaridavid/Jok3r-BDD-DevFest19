## JOK3R🤡

This is a sample android application used during my demo on Behavious Driven Development on Android.

It consumes from a [Jokes API](https://rapidapi.com/Sv443/api/jokeapi) from [Rapid API](https://rapidapi.com)

### Prerequisites

1. You'll need to get your developer key from Rapid Api to make requests to the endpoints.More on that [here](https://docs.rapidapi.com/docs/keys).
2.  Once you have your Rapid API key,you will need to add it to a global ```gradle.properties``` file so as not to add it to
 version control and expose your key and configure the projects app module build.gradle to reflect the name you gave your
 API Key.
 To Access the global ```gradle.properties``` ,Locate the `.gradle` file in the following directory
    
    - <b>Windows</b>: C:\Users\\\<Your Username>\\\.gradle

    - <b>Mac:</b> /Users<Your Username>/.gradle   
     
    - <b>Linux:</b> /home<Your Username>/.gradle 
 
    If it doesn't exist create one and add in your API key like so
 
     ```properties
    JOK3R_API_KEY = 'API_KEY_VALUE'
    ```
 
3. The rest is all done now just run your app.👻