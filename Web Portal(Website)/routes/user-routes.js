// Initialize express router
let router                 = require('express').Router(),
    User                   = require("../models/userModel"),
    Leader                   = require("../models/leaderModel"),
    Vote                   = require("../models/votesModel"),
    bodyParser             = require('body-parser'),
    mongoose               = require('mongoose'),
    passport               = require('passport'),
    LocalStrategy          = require('passport-local'),
    passportLocalMongoose  = require("passport-local-mongoose");


router.get("/dashboard/:id",isLoggedIn, function(req, res){
    //find the user with provided ID
    User.findById(req.params.id).exec(function(err, foundUser){
        if(err){
            console.log(err);
        } else {
            console.log(foundUser);
            Leader.find({ constituency: foundUser.constituency}, function(err, constituencyLeaders) {
                if (err) {
                    res.json({
                        status: "error",
                        message: err,
                    });
                }
                console.log(constituencyLeaders);
                //render show template with that user and leaders
                res.render("polling", {user: foundUser, leaders: constituencyLeaders});
            });
        }
    });
});

//Check if user is already logged in
function isLoggedIn(req, res, next){
    if(req.isAuthenticated()){
        return next();
    }
    res.redirect("/login");
}

 // Export User routes
 module.exports = router;