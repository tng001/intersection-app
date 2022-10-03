import * as chechbox from 'semantic-ui-checkbox';

export class CheckboxComponent {
    // this is a really messed up logic for selection the checkboxes... I'm not a good frontend developer :D
    public initComponent = (): void => {
        $('.ui.checkbox').checkbox();
        $('.first')
            .checkbox('set checked')
            .checkbox({
                onChecked: () => {
                    $('.second').checkbox('set unchecked');
                    $('.third').checkbox('set unchecked');
                    $('.fourth').checkbox('set checked');
                },
                onUnchecked: () => {
                    $('.second').checkbox('set checked');
                    $('.third').checkbox('set checked');
                    $('.fourth').checkbox('set unchecked');
                },
            });

        $('.second').checkbox({
            onChecked: () => {
                $('.first').checkbox('set unchecked');
                $('.third').checkbox('set checked');
                $('.fourth').checkbox('set unchecked');
            },
            onUnchecked: () => {
                $('.first').checkbox('set checked');
                $('.third').checkbox('set unchecked');
                $('.fourth').checkbox('set checked');
            },
        });

        $('.third').checkbox({
            onChecked: () => {
                $('.first').checkbox('set unchecked');
                $('.second').checkbox('set checked');
                $('.fourth').checkbox('set unchecked');
            },
            onUnchecked: () => {
                $('.first').checkbox('set checked');
                $('.second').checkbox('set unchecked');
                $('.fourth').checkbox('set checked');
            },
        });

        $('.fourth')
            .checkbox('set checked')
            .checkbox({
                onChecked: () => {
                    $('.first').checkbox('set checked');
                    $('.second').checkbox('set unchecked');
                    $('.third').checkbox('set unchecked');
                },
                onUnchecked: () => {
                    $('.first').checkbox('set unchecked');
                    $('.second').checkbox('set checked');
                    $('.third').checkbox('set checked');
                },
            });
    };
}
