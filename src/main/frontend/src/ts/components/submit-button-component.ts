import { RequestModel } from '../model/request-model';
import { getIntersectionData } from '../api/request';

export class SubmitButtonComponent {
    private checkedSelector = '.checked';
    private resultsSelector = '.results';

    public initComponent = (): void => {
        $('.ui.submit.button').on('click', async () => {
            $(this.resultsSelector).hide();
            const requestDto = this.initRequestDto();
            const resultDto = await getIntersectionData(requestDto);
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
            toPutInHashset: $(this.checkedSelector)[0].title,
            toIterateOver: this.getToIterateOver(),
        };
    };

    private getToIterateOver = (): string => {
        if ($(this.checkedSelector)[1].title == 'third') {
            return 'first';
        }
        if ($(this.checkedSelector)[1].title == 'fourth') {
            return 'second';
        }
    };
}
