// Initialize express router
let router                 = require('express').Router();
    User                   = require("../models/userModel")
    bodyParser             = require('body-parser'),
    mongoose               = require('mongoose'),
    passport               = require('passport'),
    LocalStrategy          = require('passport-local'),
    passportLocalMongoose  = require("passport-local-mongoose");

// Register routes

//show sign up form
router.get("/register", function(req, res){
    res.render("regis"); 
 });

 //handling user sign up
router.post("/register", function(req, res){
    User.register(new User({username: req.body.username, pin: generatePin(), constituency: req.body.constituency, secureAns1: req.body.answer1, secureAns2: req.body.answer2, secureAns3: req.body.answer3}), req.body.password, function(err, user){
        if(err){
            console.log(err);
            return res.render('regis');
        }
        passport.authenticate("local")(req, res, function(){
            res.redirect("/dashboard/" + req.user._id);
        });
    });
});

router.post("/register.json", function(req, res){
    User.register(new User({username: req.body.username, pin: generatePin(), constituency: req.body.constituency, secureAns1: req.body.answer1, secureAns2: req.body.answer2, secureAns3: req.body.answer3}), req.body.password, function(err, user){
        if(err){
            console.log(err);
            return res.render('regis');
        }
        passport.authenticate("local")(req, res, function(){
            res.json({
                message: 'New user created!',
                data: user.constituency
            });
        });
    });
});

function generatePin() {
    return Math.floor(Math.random() * (99999 - 10000) + 10000)   //generates a random number between 10000 and 99999
}

// Export Register routes
module.exports = router;