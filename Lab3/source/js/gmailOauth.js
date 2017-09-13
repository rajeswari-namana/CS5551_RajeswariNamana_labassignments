/**
 * Created by rajin on 9/12/2017.
 */

// signing into Gmail
function onSignIn(googleUser) {
    var profile = googleUser.getBasicProfile();
    var name=("Hi " + profile.getName());
    var navigation=("Continue to app");
    // for getting Gmail user name
    document.getElementById("hi").innerHTML=name;
    document.getElementById("navi").innerHTML=navigation;
}
//signing out of Gmail
function signOut() {
    var auth2 = gapi.auth2.getAuthInstance();
    auth2.signOut().then(function () {
        alert('User signed out.');
    });
}