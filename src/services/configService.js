const LOCAL = {
    urls: {
        allUsers: "http://localhost:8080/pheru-darts/users"
    }
};
const LOCAL_ERROR = {
    urls: {
        allUsers: "http://localhost:8080/pheru-darts/testfehler"
    }
};
const PRODUCTION = {
    urls: {
        allUsers: "TODO"
    }
};

const LOCAL_ERROR_MODE_STRING = "testmodefail";

export function getConfig() {
    switch (window.location.hostname) {
        case "localhost":
            if (window.location.search.includes(LOCAL_ERROR_MODE_STRING)) {
                return LOCAL_ERROR;
            }
            return LOCAL;
        default:
            return PRODUCTION;
    }
}

