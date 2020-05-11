const PRODUCTION_HOST = process.env.REACT_APP_BACKEND_HOST;

const DEV_PROTOCOL = "http:";
const DEV_PORT = "8080";

class ConfigUtil {
    static getConfig() {
        if (process.env.NODE_ENV === 'production') {
            return configForHost(PRODUCTION_HOST);
        } else {
            return configForHost(devHostForHostname(window.location.hostname));
        }
    }
}

function devHostForHostname(hostname) {
    return DEV_PROTOCOL + "//" + hostname + ":" + DEV_PORT;
}

function configForHost(host) {
    return {
        resourceUrls: {
            user: host + "/user",
            playerPermission: host + "/playerPermission",
            game: host + "/game",
            statistic: host + "/statistic",
            serverInformation: host + "/serverInformation",
            notification: host + "/notification"
        },
        loginUrl: host + "/login",
        logoutUrl: host + "/logout"
    };
}

export default ConfigUtil;