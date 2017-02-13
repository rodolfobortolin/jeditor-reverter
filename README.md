It is a servlet that you can send some parameters in the URL and it will show in the left column the html that is in the field (current value), and on the right, the future converted value (JIRA markup language).

One small example is attached to this email.

Explanation of the parameters:

* base URL: http://localhost/plugins/servlet/jeditor-reverter
* project= The project key that you want to verify
* size= the number of issues you want to see
* start= the start of the pagination 
* customFieldId= the custom field id ex: 11803

and last but not least:

* edit= y or n (this one is very important, since if you send y, it will change the field to markup language for good, so we will only use this when we are ok to modify the values).