var hostnameinfo = function() {
};

hostnameinfo.getHostname = function( success, fail ) {
    cordova.exec( success, fail, "hostnameinfo", "getHostName", [] );
};

module.exports = hostnameinfo;
