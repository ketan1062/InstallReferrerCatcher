var exec = require('cordova/exec');

var installReferrerCatcher = {
    getReferrer:function(success, error) {
        exec(success, error, "InstallReferrerCatcher", "referrer", [{}]);
    }
};

module.exports = installReferrerCatcher;