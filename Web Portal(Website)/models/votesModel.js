var mongoose = require("mongoose");

// Setup schema
var votesSchema = mongoose.Schema({
    partyName: String,
    votes: Number,
    constituency: String
});

module.exports=mongoose.model("votes", votesSchema);