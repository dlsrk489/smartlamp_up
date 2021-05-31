let chart = {
    label : [],
    labelText : '',
    backgroundColor: '',
    borderColor: '',
    data : [],
    type:'',
    chartId : ''
}
function Init()
{

    this.init = function()
    {
        $('#login').on('click',function()
        {
            location.href="/login";
        })
        $('#logout').on('click',function()
        {
            location.href="/logout";
        })
    }

    this.itemHoverInit = function()
    {

        $('.innerItem').hover(function()
        {
            const nth = this.children[0];
            nth.classList.add("pointup");

            const newElement = document.createElement("DIV");


            $(this).append(newElement);

            newElement.classList.add("animation-init");
            newElement.id = 'chartContainer';
            setTimeout(function () {
                newElement.classList.add("animation-fade");
                nth.classList.add("pointshow");
            }, 30);

            const labels = [
                'January',
                'February',
                'March',
                'April',
                'May',
                'June',
            ];
            const data = {
                labels: labels,
                datasets: [{
                    label: 'My First dataset',
                    backgroundColor: 'rgb(255, 99, 132)',
                    borderColor: 'rgb(255, 99, 132)',
                    data: [0, 10, 5, 2, 20, 30, 45],
                }]
            };

            const config = {
                type: 'line',
                data,
                options: {}
            };
            var myChart = new Chart(
                document.getElementById('chartContainer'),
                config
            );

        },function()
        {
            const nth = this.children[0];
            nth.classList.remove("pointup","pointshow")

            $('#chartContainer').remove();
        });

    }
    this.chartInit = function(chart)
    {
        const labels = chart.label;
        const data = {
            labels: labels,
            datasets: [{
                label: chart.labelText,
                backgroundColor: chart.backgroundColor,
                borderColor: chart.borderColor,
                data: chart.data,
            }]
        };

        const config = {
            type: chart.type,
            data,
            options: {}
        };
        new Chart(
            document.getElementById(chart.chartId),
            config
        );
    }
}

const initInfo = new Init();
initInfo.init();
initInfo.itemHoverInit();