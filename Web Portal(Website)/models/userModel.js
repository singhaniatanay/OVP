var mongoose = require("mongoose");
var passportLocalMongoose = require("passport-local-mongoose");

var UserSchema = new mongoose.Schema({
   username: String,
   password: String,
   pin: Number,
   secureAns1: String,
   secureAns2: String,
   secureAns3: String,
   constituency: String
});

UserSchema.plugin(passportLocalMongoose);

module.exports=mongoose.model("User", UserSchema);