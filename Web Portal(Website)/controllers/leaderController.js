// Import leader model
Leader = require('../models/leaderModel');

// Handle index actions
exports.index = function (req, res) {
    Leader.get(function (err, leaders) {
        if (err) {
            res.json({
                status: "error",
                message: err,
            });
        }
        res.json({
            status: "success",
            message: "Leaders retrieved successfully",
            data: leaders
        });
    });
};

// Handle index constituency actions for retrieving leaders based on a specific constituency
exports.indexConstituency = function (req, res) {
    Leader.find({ constituency: req.params.constituency}, function(err, constituencyLeaders) {
        if (err) {
            res.json({
                status: "error",
                message: err,
            });
        }
        res.json({
            status: "success",
            message: "Leaders retrieved successfully for " + req.params.constituency,
            data: constituencyLeaders
        });
    });
};

// Handle create leader actions
exports.new = function (req, res) {
    var leader = new Leader();
    leader.name = req.body.name ? req.body.name : leader.name;
    leader.partyName = req.body.partyName;
    leader.constituency = req.body.constituency;
    leader.info = req.body.info;
    leader.photo = req.body.photo;
    leader.partySymbol = req.body.partySymbol;

// save the leader and check for errors
    leader.save(function (err) {
        if (err)
            res.json(err);
        res.json({
            message: 'New leader created!',
            data: leader
        });
    });
};

// Handle view leader info
exports.view = function (req, res) {
    Leader.findById(req.params.leader_id, function (err, leader) {
        if (err)
            res.send(err);
        res.json({
            message: 'Leader details loading..',
            data: leader
        });
    });
};

// Handle update leader info
exports.update = function (req, res) {
Leader.findById(req.params.leader_id, function (err, leader) {
        if (err)
            res.send(err);
leader.name = req.body.name ? req.body.name : leader.name;
        leader.partyName = req.body.partyName;
        leader.constituency = req.body.constituency;
        leader.info = req.body.info;
        leader.photo = req.body.photo;
        leader.partySymbol = req.body.partySymbol;

// save the leader and check for errors
        leader.save(function (err) {
            if (err)
                res.json(err);
            res.json({
                message: 'Leader Info updated',
                data: leader
            });
        });
    });
};

// Handle delete leader
exports.delete = function (req, res) {
    Leader.remove({
        _id: req.params.leader_id
    }, function (err, leader) {
        if (err)
            res.send(err);
        res.json({
            status: "success",
            message: 'Leader deleted'
        });
    });
};