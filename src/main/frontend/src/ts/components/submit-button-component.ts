import { RequestModel } from '../model/request-model';
import { getIntersectionData } from '../api/request';

export class SubmitButtonComponent {
    private resultsSelector = '.results';

    public initComponent = (): void => {
        $('.ui.submit.button').on('click', async () => {
            $(this.resultsSelector).hide();
            const requestDto = this.initRequestDto();
            const resultDto = await getIntersectionData(requestDto);
            console.log(resultDto);
            $('#time').text(resultDto.time);
            $('#intersection-size').text(resultDto.intersectionSize);
            $('#intersection').text(resultDto.intersection.join(', '));
            $('#first-list').text(resultDto.firstCollection.join(', '));
            $('#second-list').text(resultDto.secondCollection.join(', '));
            $(this.resultsSelector).show();
        });
    };

    private initRequestDto = (): RequestModel => {
        return {
            firstSize: <number>$('.first-size').val(),
            secondSize: <number>$('.second-size').val(),
            firstToHashSet: $('.checkbox').checkbox('is checked'),
        };
    };
}
