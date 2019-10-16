from rest_framework.viewsets import ReadOnlyModelViewSet

from ..models import Equipment
from ..serializers import EquipmentSerializer


class EquipmentViewSet(ReadOnlyModelViewSet):
    serializer_class = EquipmentSerializer
    queryset = Equipment.objects.all()