# Android Interview Challenge

## General Commentary

    - The instructions may or may not be complete and exact.
    - The methods you use to complete the exercise are not as important as letting us
      know the processes you are using to accomplish the task.  Talk through your
      approach to finding a solution.
    - You can use any resources you deem necessary.
    - You need to let us know what resources you are using:  screenshare your documentation
      searches, talk through using an offline reference (book, etc.), talk through it
      you are familiar with the methods you need to use, etc.

## Step One - Implement Login

    You need to implement basic login for our example activity. We have provided a mock web service
    for you to work against bundled within this application, as well as models and a basic
    architecture. Feel free to extend\alter this structure if you believe it would be better for
    the application to do so.

    For the purposes of testing your implementation use the username "user" and the
    password "pw" as valid login credentials.

    Finally, we have provided a basic set of instructions to implement login:

    ### Part One
     Create a databound layout file for login.
        - The layout should contain at least
            * A text field where the user can enter a username.
            * A text field where the user can enter a password.
            * A button to allow the user to indicate they wish to login.
            * A checkbox to allow the user to indicate they wish to save their username for
              future use.

    ### Part Two
     Bind this layout file to either a new or already existing lifecycle component.

    ### Part Three
     The values of all input fields should be persisted when the user rotates their screen.

    ### Part Four
     Validate the user's input data on login submission:
        - Valid username input is defined as a string of non-zero length containing 1 or
          more non-whitespace characters.
        - Valid password input is defined as a string of non-zero length containing 1 or
          more non-whitespace characters.

    ### Part Five
     When the user clicks the login button a number of things should happen in the
       appropriate sequence:
        - User input is used to send a login request via the InterviewWebService.
        - The response from the login attempt is appropriately handled.
            * Focus on the happy path (success case) first.  If there is time, revisit any
              other cases.
        - If the login is successful, start the ProfileActivity.
    ### Part Six
     Fix any errors you encounter along the way.

## Step Two - Implement Profile

    Now that we've logged in, we would like to display a basic profile screen. Using the same mock
    web service, retrieve a profile and then using the layouts and lifecycle components provided,
    finish the implementation.

    ### Part One
     Create a data model for a profile. A profile should have:
             - A name.
             - A percentage representing their progress.
             - Any number of skills.