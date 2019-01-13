let express = require('express'),
    apiRoutes              = require("./routes/api-routes"),
    regRoutes              = require("./routes/register-routes"),
    loginRoutes            = require("./routes/login-routes"),
    userRoutes             = require("./routes/user-routes"),
    User                   = require("./models/userModel"),
    http                   = require('http'),
    bodyParser             = require('body-parser'),
    mongoose               = require('mongoose'),
    passport               = require('passport'),
    LocalStrategy          = require('passport-local'),
    passportLocalMongoose  = require("passport-local-mongoose");

let app = express();

// Connect to Mongoose and set connection variable
mongoose.connect('mongodb://localhost/ecVoting');
var db = mongoose.connection;

// Configure bodyparser to handle post requests
app.use(bodyParser.urlencoded({
    extended: true
 }));

 app.use(bodyParser.json());

 app.use(require("express-session")({
    secret: "OVP",
    resave: false,
    saveUninitialized: false
}));

app.use(function(req,res,next) {
    res.locals.currentUser=req.user;
    next();
 });

app.use(passport.initialize());
app.use(passport.session());

passport.use(new LocalStrategy(User.authenticate()));
passport.serializeUser(User.serializeUser());
passport.deserializeUser(User.deserializeUser());


app.set("view engine","ejs");
app.use(express.static(__dirname + "/public"));
 
// Send message for default URL
app.get("/",function(req,res){
    res.render("home", {currentUser: req.user}); 
 });

 app.get("/manifesto",function(req,res){
    res.render("manifesto", {currentUser: req.user}); 
 });

 app.get("/leaders",function(req,res){
    res.render("contestant", {currentUser: req.user}); 
 });

 app.get("/about",function(req,res){
    res.render("abouteci", {currentUser: req.user}); 
 });

 // Use Api routes in the App
app.use('/api', apiRoutes)

// Using Register/Sign-up routes
app.use(regRoutes)

// Using Login routes
app.use(loginRoutes)

// Using User routes
app.use(userRoutes)

//logout
app.get("/logout", function(req, res){
    req.logout();
    res.redirect("/");
});

//Check if user is already logged in
function isLoggedIn(req, res, next){
    if(req.isAuthenticated()){
        return next();
    }
    res.redirect("/login");
}

//Setup server port
var port = process.env.PORT || 8080;


// app.set('port', process.env.PORT || 8000);
// app.set('host', process.env.HOST || '10.194.203.242');

// http.createServer(app).listen(app.get('port'), app.get('host'), function(){
//   console.log("Express server listening on port " + app.get('port'));
// });

// Launch app to listen to specified port
app.listen(port, function () {
     console.log("Running OVP on port " + port);
});