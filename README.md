# cordova-plugin-HostnameInfo

Check if plugin is defined:
```javascript
if((typeof(hostnameinfo) === "undefined"))
    $parameters.IsAvailable = false;
else
    $parameters.IsAvailable = true;
```


Define it in your module:
```javascript
function onSuccess(hostname) {
  $parameters.Success = true;
  $parameters.Hostname = hostname;
}

function onError(error) {
  $parameters.Success = false;
  $parameters.ErrorMessage = error;
}

hostnameinfo.getHostname(onSuccess, onError);
```

## Extensibility Configurations

from github
```json
{
    "plugin" : {
        "url" : "https://github.com/miltinhoc/cordova-plugin-HostnameInfo.git"
    }
}
```
from a zip file
```json
{
    "resource": "cordova-plugin-hostnameinfo.zip",
    "plugin": {
        "resource": "cordova-plugin-hostnameinfo"
    }
}
```
