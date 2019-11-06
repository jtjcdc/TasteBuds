# TasteBuds
Group Project - README Template
===

# TasteBuds

## Table of Contents
1. [Overview](#Overview)
1. [Product Spec](#Product-Spec)
1. [Wireframes](#Wireframes)
2. [Schema](#Schema)

## Overview
### Description
TasteBuds is a food social media network that makes food and restaurant recommendations based on users who share similar tastes.

### App Evaluation
- **Category:** Social Networking / Food
- **Mobile:** This applicaion would be primarily developed for mobile and maybe a website base computer application as well. This appliation would rely on the phones GPS and locations. It would also alert the user with push notifiactions. 
- **Story:** Analyzes users' food choices and connects them to other users with similiar tastes. The user could share, rate, and review their favorite restautrant and foods which would help other users decide what to try.
- **Market:** Anyone could use this app, but people who are picky, undecisive, foodies, or have dietary restricitions would especially.
- **Habit:** The app would be used often if the user is often trying new restaurants and dishes, or has the desire to. Overall, it would depend on the users' curiousity to try new foods, or about what others are trying. The application would also have a likes and dislikes feature where users would be able to like and comment on reivews that would give them an incentive to post.
- **Scope:** First, we would start by pairing people based on food taste and allowingusers to share and post reviews 

## Product Spec

### 1. User Stories (Required and Optional)

**Required Must-have Stories**

* User creates a profile(can add faves, dislikes, etc.)
* User gets matched with people with similar taste profiles and can choose to follow their matches and see their recently tried foods, restaurants, recommended foods, etc. on their feed.
* Matches have a chat window option(they can possibly meet up and go out to eat together)
* User can search for foods, restaurants, reviews, or other users
* Settings (change language, notifications, match settings, etc.)


**Optional Nice-to-have Stories**

* Sync with other social media
* Ability to share and post recipes
* Page of the most popular dish and restaurant for each taste tag the user has
* User can toggle the settings to view only local matches, or national ones.

### 2. Screen Archetypes

* Login

* Register
   * Allows the user to setup an Account name/password and touch ID/Face ID.
   * The user would then put in there information and then be directed to the Assessment Screen.
   
* Matches Screen
   * This will allow the user to see people with similar tastes in food.
   * There will be a button that will direct the user to the chat screen.
   
* Chat Screen
   * Allows the user to connect with matched accounts on a direct one to one connection.
   
* Settings Screen
   * This screen will allow the user to change profile pictures edit their personal information, block unwanted users, etc.
   
* Profile Screen
   * User creates a profile where theyshare relevant information about themselves such as location, a short bio and likes/dislikes in food.
 
 * Recommendedations 
   * User will get recommendations based on their taste matches recommendations and tags  
   
* Taste Assessments Screen
   * This screen will feature a test assessment about 30 or more questions that will determine what kind of foods the user      likes. The user would then be given tag base on how the answer the questions. The user will be given a maxmimum of 5 tags.
   
* Camera Screen
   * This will call the camera API which the user would be able to take a profile picture
   * The Camera screen would also be able to have access the gallery part of the users phone to upload a profile picture.
   
* Notification Screen
   * The Notification screen will allow the user to see what likes and comments on the the reviews that they leave.
   * Also the 
   
* Explore 
   * User can search for foods, restaurants, reviews, or other users
   
* News feed Screen
   * The News Feed will show people's prefered restaurant and prefered dishes. The will be displayed to the user as a list view form.

### 3. Navigation

**Tab Navigation** (Tab to Screen)

* Login
* Profile
* Matches
* Setting
* Camera
* News Feed
* Explore / Recommendations
* Chat



**Flow Navigation** (Screen to Screen)

* Forced Log In -> Account Creation if no log in information is available
   * Forced Log - > News Feed
  
* News  Feed -> Explore / Recommendation 
   *News Feed -> Toggles a write a review page that allows User to take photo of food item -> Camera
 
* Profile -> Access Your Settings 
   * Profile -> View and edit Profile
  
* Matches -> View Other Users Profile in your matches/friends/followers
   * Matches-> Chat
   
* Setting-> Toggle Settings
   
* Camera->  Profile Allows the user to take profile information
  
* Explore / Recommendation->  Search for restaurants, users, etc.
   
## Wireframes
<img src="https://i.imgur.com/jcBonrW.jpg" width=600>

### [BONUS] Digital Wireframes & Mockups
<img src="https://i.imgur.com/pRlmfYo.png" height=200> <img src="https://i.imgur.com/nP1cS0J.png" height=200> 
<img src="https://i.imgur.com/vv5TMt9.png" height=200> <img src="https://i.imgur.com/a2Bmrkh.png" height=200>
<img src="https://i.imgur.com/m3rxCjA.png" height=200> <img src="https://i.imgur.com/TrusXHX.png" height=200> 
<img src="https://i.imgur.com/gdQTICM.png" height=200> <img src="https://i.imgur.com/QCGiJNf.png" height=200>
<img src="https://i.imgur.com/1WBrhHb.png" height=200>


### [BONUS] Interactive Prototype

## Schema 
[This section will be completed in Unit 9]
### Models
Post

| Property      | Type          | Description |
| ------------- |-------------  | ----- |
| object        | String        | Unique id for the user post   
| author        | Pointer to user| Image author     
| image         | file          | Image file the user post 
| Caption       | String        | Image caption by author
| commentsCount | int           | Number of comments that has been posted
| location      | JSON          | Stores the location of the user
| object        | String        | Unique id for the user post
| likesCount    | int           | Number of likes for the post
| Created_at    | DateTime      | Date when post is created (default)
| Updated_at    | DateTime      | Date when post is last created (default)
| rating        | double        | A value that holds the rating

Restaurant 

| Property      | Type          | Description |
| ------------- |-------------  | ----- |
| id            | int           | Unique id for the restaurant   
| name          | String        | Name of the restaurant    
| address       | String        | Address of the restaurant 
| locality      | String        | This is the venue or plaza of the location
| city          | String        | City name
| latitude      | float         | The latitude displayed as a float
| longitude     | float         | The longitude displayed as a float
| zipcode       | int           | Zipcode of the restaurant 
| cuisines      | string        | Cuisines offered at each restaurant
| url           | String        | The url of the website
| all_reviews_count| int        | Holds all of the review counts
| rating        | int           | Holds the ratings
| review_text   | String        | The user’s review, max 5000 characters 

Log In

| Property      | Type          | Description |
| ------------- |-------------  | ----- |
| username      | String        | Unique id for the user log in (default)   
| password      | String        | Unique password for the user (default)
 

Tags 

| Property      | Type          | Description |
| ------------- |-------------  | ----- |
| tagName       | String        | Name of the tag   
| bgButton      | file          | Background color/image of the tag


Profile 

| Property      | Type          | Description |
| ------------- |-------------  | ----- |
| username      | String        | User’s name   
| profileImage  | file          | Profile picture
| bio           | String        | A short bio, max 160 characters 

Settings 

| Property      | Type          | Description |
| ------------- |-------------  | ----- |
| location      | object        | User locatin   
| avatar        | file          | Profile picture
| bio           | String        | A short bio, max 160 characters 
| username      | String        | User's name
| email         | String        | User's email
| password      | String        | User's password
| notifications | Bool          | Option to receives notifications from the app

Matches 

| Property      | Type          | Description |
| ------------- |-------------  | ----- |
| matchID       | int           | Unique id used for matches   
| Created_at    | DateTime      | Date when match was created (default)
| Deleted_at    | DateTime      | Date when the match was deleted 


### Networking
- Log in Screen
* (Create/Login) if the user does not have an account allow them to create one.
- Matches Screen
* (Delete/Matches) Deleting existing matched profiles 
* (Block/Matches) block certain profiles from seeing your profile.
- Chat Screen
* (Create/Message) message multiple matches.
* (Delete/Messages) deleting existing message on your Account
- Camera Screen
* (Capture/Photo) takes profile picture and takes food pictures
* (Deleting/Photo) Deletes profile picture and food picture
- Settings Screen
* (Delete/Account) Deleting Account
- News Feed Screen
* (Read/Get) Query post where the user is author
* (Create/Post) Create a new post
* (Delete) Deleting existing like
* (Create/Post) Create a new comment on a post
* (Delete) Delete existing comment
- Explore
* (Search/Restaurant) find local restaurants
* (Search/Profiles)   find nearby profiles

- Zomato API https://developers.zomato.com/documentation

Common

|Get         | Endpoint            | Description                           |
|------------|---------------------|----------------------------------------
| get        |  /categories        | Get list of categories
| get        |  /cities            | Get city detail
| get        |  /collection        | Get Zomato collections in a city
| get        |  /cuisines          | Get list of all cuisines in a city
| get        |  /geocode           | Get locations details based on coordinates

Location

|Get         | Endpoint            | Description           |
|------------|---------------------|------------------------
| get        |  /location_detail   | Get Zomato location details
| get        |  /locations         | Search for locations

Restaurant

|Get         | Endpoint            | Description
|------------|---------------------|------------------------
| get        |  /dailymenu         | Get Zomato location details
| get        |  /restaurant        | Get restaurant details
| get        |  /reviews           | Get restaurant reviews
| get        |  /search            | Search for locations
| get        |  /restaurant        | Search for restaurants
