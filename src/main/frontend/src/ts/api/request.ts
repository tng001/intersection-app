import { RequestModel } from '../model/request-model';
import { ResultModel } from '../model/result-model';

export const getIntersectionData = async (requestDto: RequestModel): Promise<ResultModel> => {
    return new Promise((resolve, reject) => {
        $.ajax({
            type: 'GET',
            url: 'http://localhost:8080/api/intersection',
            data: requestDto,
            success: function (resultDto: ResultModel) {
                // let's suppose that the backend validation did not fail :)
                // if it fails, we need to show this to the user
                // the request will be successful, however we will have the error message in the response
                resolve(resultDto);
            },
            error: function (error) {
                // let's suppose that we do not have errors for simplicity
                // if we do, we would need a message component where we can show the error for the user
                reject(error);
            },
        });
    });
};
