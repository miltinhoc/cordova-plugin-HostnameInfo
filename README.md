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
