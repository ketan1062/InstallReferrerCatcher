interface CordovaPlugins {
    InstallReferrerCatcher: InstallReferrerCatcher;
}

interface InstallReferrerCatcher {
    getReferrer(success: any, error: any): void;
}