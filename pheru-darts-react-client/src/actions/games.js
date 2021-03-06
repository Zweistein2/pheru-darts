import FetchUtil from "../util/FetchUtil";
import ConfigUtil from "../util/ConfigUtil";
import {showError} from "./modal";
import ActionUtil from "../util/ActionUtil";

export const REQUEST_ARCHIVE_GAME = 'REQUEST_ARCHIVE_GAME';
export const ARCHIVE_GAME_SUCCESSFUL = 'ARCHIVE_GAME_SUCCESSFUL';
export const ARCHIVE_GAME_FAILED = 'ARCHIVE_GAME_FAILED';

export const requestArchiveGame = () => ({
    type: REQUEST_ARCHIVE_GAME
});
export const archiveGameSuccessful = () => ({
    type: ARCHIVE_GAME_SUCCESSFUL
});
export const archiveGameFailed = (message) => ({
    type: ARCHIVE_GAME_FAILED,
    message
});

export function archiveGame(game) {
    return function (dispatch) {
        dispatch(requestArchiveGame());
        return FetchUtil.fetchPost(ConfigUtil.getConfig().resourceUrls.game,
            game,
            json => dispatch(archiveGameSuccessful()),
            responseNotOk => {
                dispatch(archiveGameFailed(responseNotOk.message));
                ActionUtil.defaultErrorHandling(dispatch, responseNotOk, showError("Could not archive game", responseNotOk.message));
            },
            error => {
                dispatch(archiveGameFailed(error.message));
                dispatch(showError("Could not archive game", error.message));
            }
        );
    };
}



