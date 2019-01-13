// Import leader model
Vote = require('../models/votesModel');

//Handle submit action
exports.submit = function (req, res) {
    Vote.find({ partyName: req.params.partyName, constituency: req.params.constituency }, function (err, vote) {
            if (err)
                res.send(err);
            vote.partyName = vote.partyName;
            vote.constituency = vote.constituency;
            vote.votes = vote.votes + 1;

    
    // save the vote and check for errors
            vote.save(function (err) {
                if (err)
                    res.json(err);
                res.json({
                    message: 'Vote added',
                    data: vote
                });
            });
        });
    };