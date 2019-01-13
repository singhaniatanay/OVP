var mongoose = require('mongoose');

// Setup schema
var leaderSchema = mongoose.Schema({
    name: String,
    partyName: String,
    photo: String,
    constituency: String,
    info: String,
    partySymbol: String
});
// Export Leader model
var Leader = module.exports = mongoose.model('leader', leaderSchema);
module.exports.get = function (callback, limit) {
    Leader.find(callback).limit(limit);
}