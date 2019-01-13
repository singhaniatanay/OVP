// Initialize express router
let router                 = require('express').Router(),
    User                   = require("../models/userModel")
    bodyParser             = require('body-parser'),
    mongoose               = require('mongoose'),
    passport               = require('passport'),
    LocalStrategy          = require('passport-local'),
    passportLocalMongoose  = require("passport-local-mongoose");

// Login routes

//render login form
router.get("/login", function(req, res){
    res.render("logineci"); 
 });
 
 //login logic
 //middleware
 router.post("/login", passport.authenticate("local", {
     failureRedirect: "/login"
 }) ,function(req, res){
     res.redirect("/dashboard/" + req.user._id);
 });

 router.post("/login.json", passport.authenticate("local", {
    failureRedirect: "/login"
}) ,function(req, res){
    res.json({
        message: 'User Logged in!',
        data: req.user.constituency
    });
});

 //Check if user is already logged in
function isLoggedIn(req, res, next){
    if(req.isAuthenticated()){
        return next();
    }
    res.redirect("/login");
}

 // Export Register routes
module.exports = router;